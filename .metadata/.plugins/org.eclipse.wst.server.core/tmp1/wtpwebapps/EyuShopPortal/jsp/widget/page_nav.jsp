<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
		<div id="page_nav" class="layui-col-md12" style="text-align: center;">
				<ul>
					<li>
						<button id="btn_prePage" class="layui-btn layui-btn-xs">
							<i class="layui-icon layui-icon-left" style=""></i>
						</button>
					</li>
					
					<li id="navigation_nums">
						
					</li>
					
					<li>
						<button id="btn_nextPage"  class="layui-btn layui-btn-xs">
							<i class="layui-icon layui-icon-right"></i>
						</button>
					</li>
					
					<li>
						总页数:<span id="pages" style="font-size:16px;color:#009688">0</span>
					</li>
					
					<li>
						跳到:<input id="input_skipPage" type="text" style="border:none;height:20px;width:32px;border-radius:5px;"/>
						<button id="btn_skipPage"  class="layui-btn layui-btn-xs">
							<i class="layui-icon layui-icon-release"></i>
						</button>
					</li>
				</ul>
			</div>
</body>
</html>