<!-- 
区域选择标签定义
样式：基于bootstrap3.3.0
作者：bing.ning@balintimes.com 2014-12-05
 -->

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/ztree.jsp"%>

<%@ attribute name="id" type="java.lang.String" required="true"
	description="编号"%>
<%@ attribute name="name" type="java.lang.String" required="true"
	description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true"
	description="隐藏域值（ID）"%>
<%@ attribute name="labelName" type="java.lang.String" required="true"
	description="输入框名称（Name）"%>
<%@ attribute name="labelValue" type="java.lang.String" required="true"
	description="输入框值（Name）"%>
<%@ attribute name="disabled" type="java.lang.String" required="false"
	description="是否限制选择，如果限制，设置为disabled"%>

<!-- 区域选择标签定义：html begin-->
<div class="input-group">
	<input id="${id}Id" name="${name}" class="form-control" type="hidden"
		value="${value}" ${disabled eq 'true' ? ' disabled=\'disabled\'' : ''} />
	<input id="${id}Name" name="${labelName}" readonly="readonly"
		type="text" value="${labelValue}" maxlength="50"
		${disabled eq "true"? " disabled=\"disabled\"":""}"
		class="form-control" />
	
	<span class="input-group-btn"> <!-- Button trigger modal -->
		<button id="${id}Button" class="btn btn-default" type="button"
			data-toggle="modal" data-target="#myModal"
			${disabled eq 'true' ? ' disabled' : ''}>选择</button>
	</span>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">区域选择</h4>
			</div>
			<div class="modal-body">
				<div id="tree" class="ztree" style="padding: 15px 20px;"></div>
				
				<img id="indicator" alt="" src="<c:url value='/img/ajax-loader.gif' />">
				
				<div id="error" class="alert alert-danger" role="alert">
					获取数据失败！ <a href="#" class="alert-link">刷新</a>
				</div>
			</div>
			<div class="modal-footer">
				<button id="modalCancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button id="modalOk" type="button" class="btn btn-primary" tooltip="请指定区域">确定</button>
			</div>
		</div>
	</div>
</div>
<!-- 区域选择标签定义：html end-->

<!-- 区域选择标签定义：javascript begin-->
<script type="text/javascript">
	var tree;
	var setting = {
		view : {
			selectedMulti : false
		}, //禁止多点选中
		check : {
			enable : "${checked}",
			nocheckInherit : true
		},
		data : {
			// 官方建议:如果设置为 true，请务必设置 setting.data.simpleData 内的其他参数: idKey / pIdKey / rootPId
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : 0,
			}
		},
		view : {
			fontCss : function(treeId, treeNode) {
				return {
					"font-weight" : (!!treeNode.highlight) ? "bold" : "normal"
				};
			}
		},
		callback : {
			onClick : function(treeId, treeNode) {
				/*
				var treeObj = $.fn.zTree.getZTreeObj(treeNode);
				var selectedNode = treeObj.getSelectedNodes()[0];
				$("#areaId").val(selectedNode.id);
				$("#areaName").val(selectedNode.name);
				*/
			},
			onDblClick : function() {
				$('#modalOk').click();
			}
		}
	};
	
	$(document).ready(function() {
		$("#${id}Button").click(function() {
			getData();
		});

		$('#modalOk').click(function(){
			var selectedNode = tree.getSelectedNodes()[0];
			if(selectedNode != null){
				$("#areaId").val(selectedNode.id);
				$("#areaName").val(selectedNode.name);
				$('#myModal').modal('hide');
			}else{
				
			}
		});
		
		$("#error a").click(function() {
			getData();
		});
	});

	function getData() {
		$("#tree").hide();
		$("#error").hide();
		$("#indicator").show();

		//请求数据
		var request = $.ajax({
			url : "${ctx}/org/area/treeData",
		});

		//请求成功
		request.done(function(zNodes) {
			$("#indicator").hide();
			$("#tree").show();
			
			// 初始化树结构
			tree = $.fn.zTree.init($("#tree"), setting, zNodes);

			// 默认展开一级节点
			var nodes = tree.getNodesByParam("level", 0);
			for (var i = 0; i < nodes.length; i++) {
				tree.expandNode(nodes[i], true, false, false);
			}

			// 默认选择节点
			var ids = "${selectIds}".split(",");
			for (var i = 0; i < ids.length; i++) {
				var node = tree.getNodeByParam("id", ids[i]);
				if ("${checked}") {
					try {
						tree.checkNode(node, true, true);
					} catch (e) {
					}
					tree.selectNode(node, false);
				} else {
					tree.selectNode(node, true);
				}
			}
		});

		//请求失败
		request.fail(function(jqXHR, textStatus) {
			$("#indicator").hide();
			$("#error").show();
		});
	};
</script>
<!-- 区域选择标签定义：javascript end-->
