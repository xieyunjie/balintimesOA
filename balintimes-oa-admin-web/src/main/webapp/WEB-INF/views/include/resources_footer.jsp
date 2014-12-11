<!-- Bootstrap core JavaScript -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<c:url value="/js/ie10-viewport-bug-workaround.js"/>"></script>

<!-- jquery treeTable  -->
<script src="<c:url value="/js/treetable/jquery.treetable.js"/>"></script>

<!-- Custom js -->
<script type="text/javascript"> 
	$(document).ready(function() {
		//根据当前访问的url,动态设置菜单当前连接焦点(Bootstrap add active class to li)
		/*
		$('a[href="' + this.location.pathname + '"]').parent().addClass('active');
		*/
		function stripTrailingSlash(str) {
		  if(str.substr(-1) == '/') {
		    return str.substr(0, str.length - 1);
		  }
		  return str;
		}
		
		var url = window.location.pathname;  
		var activePage = stripTrailingSlash(url);
		
		$('.nav li a').each(function(){  
		  var currentPage = stripTrailingSlash($(this).attr('href'));
		
		  if (activePage == currentPage) {
		    $(this).parent().addClass('active'); 
		  } 
		});

		//设置全局ajax请求超时时间
		$.ajaxSetup({
		    timeout: 30000 //Time in milliseconds
		});
	});
</script>