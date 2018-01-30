package com.wy.easyui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/tree/data")
public class TreeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
//		resp.getWriter().write("[{\"id\": 1,\"text\": \"Node 1\",\"state\":\"closed\",    \"children\":[{\"id\":11,\"text\":\"Node 11\"},{\"id\":12,\"text\":\"Node 12\"}]},{\"id\":2,\"text\":\"Node 2\",\"state\":\"closed\"}]");
		resp.getWriter().write("[	{\"id\":\"1\",		\"text\":\"部门管理\",		\"state\":\"closed\",		\"attributes\":{},		\"children\":[			{				\"id\":\"11\",				\"text\":\"添加部门\",				\"state\":\"open\"			},			{				\"id\":\"12\",				\"text\":\"查询部门\",				\"state\":\"open\"			}		]	},	{		\"id\":\"2\",		\"text\":\"员工管理\",		\"state\":\"closed\",		\"attributes\":{},		\"children\":[			{				\"id\":\"21\",				\"text\":\"添加员工\",				\"state\":\"open\"			},			{				\"id\":\"22\",				\"text\":\"查询员工\",				\"state\":\"open\"			}		]	},	{		\"id\":3,		\"text\":\"合同管理\",		\"state\":\"closed\",		\"attributes\":{},		\"children\":[			{				\"id\":\"31\",				\"text\":\"添加合同\",				\"state\":\"open\"			},			{				\"id\":\"32\",				\"text\":\"查询合同\",				\"state\":\"open\"			}		]	},	{		\"id\":4,		\"text\":\"绩效管理\",		\"state\":\"closed\",		\"attributes\":{},		\"children\":[			{				\"id\":\"41\",				\"text\":\"添加绩效\",				\"state\":\"open\"			},			{				\"id\":\"42\",				\"text\":\"绩效统计\",				\"state\":\"open\"			}		]	},	{		\"id\":5,		\"text\":\"客户管理\",		\"state\":\"closed\",		\"attributes\":{},		\"children\":[		{				\"id\":\"51\",				\"text\":\"添加客户\",				\"state\":\"open\"			},			{				\"id\":\"52\",				\"text\":\"查询客户\",				\"state\":\"open\"			}		]	}]");
		resp.getWriter().flush();
		
	}
	
}
