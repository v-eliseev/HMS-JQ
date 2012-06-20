<div>${model}</div>
<table id="datatable"></table>
<div id="pager"></div>
<g:javascript library="jqgrid/i18n/grid.locale-en"/>
<g:javascript library="jqgrid/jquery.jqGrid.min"/>
<link rel="stylesheet" href="${resource(dir:'css',file:'ui.jqgrid.css')}" />
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#datatable").jqGrid({
			url: "${url}",
		    editurl:"${editurl}",
		    datatype: 'json',
		    colNames:${colNames},
		    colModel:${colModel},
		    jsonReader : {
				repeatitems:false
		    },
		    rowNum:10,
		    rowList:[10,20,30],
		    pager: $('#pager'),
		    sortname: 'name',
		    viewrecords: true,
		    sortorder: "asc",
		    caption:"${caption}",
		    onSelectRow: function(id){
            	if(id && id!==lastsel){
                	$('#datatable').jqGrid('restoreRow',lastsel);
                    $('#datatable').jqGrid('editRow',id,true);
                    lastsel=id;
                }
            }
		}).navGrid('#pager');
	});
</script>
