package sec03.brd02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class BoardController
 */
//@WebServlet("/board/*")	//게시판 컨트롤러가 기본 사이트임으로 board/뒤 url 붙는다.
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image2";
	BoardService boardService;
	ArticleVO articleVO;
		
	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try
		{
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();	//VO
			if(action == null)
			{
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			} else if (action.equals("/listArticles.do"))
			{
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			} else if (action.equals("/articleForm.do"))
			{
				nextPage = "/board02/articleForm.jsp";
			} else if (action.equals("/addArticle.do"))
			{
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);
				articleVO.setId("moon");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.addArticle(articleVO);
				nextPage = "/board/listArticles.do";
			}
				
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			} catch (Exception e)
		{	
				e.printStackTrace();
		}
	}
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String Encoding ="utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try
		{
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++)
			{
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField())
				{
					System.out.println(fileItem.getFieldName()
							+ "=" + fileItem.getString(Encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(Encoding));
				} else
				{
					System.out.println("파라미터이름:" + fileItem.getFieldName());
					System.out.println("파일이름:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					articleMap.put(fileItem.getFieldName(), fileItem.getName());
				if (fileItem.getSize() > 0)
				{
					int idx = fileItem.getName().lastIndexOf("\\");
					if (idx == -1)
					{
						idx = fileItem.getName().lastIndexOf("/");
					}
					
					String fileName = fileItem.getName().substring(idx+1);
					File uploadFile = new File(currentDirPath + "\\" + fileName);
					fileItem.write(uploadFile);
				}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return articleMap;
	}
}
