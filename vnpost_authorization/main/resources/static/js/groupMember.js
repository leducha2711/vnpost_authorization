function deleteGroup(data) {
	if(confirm("Xác nhận xóa")){
		
		ajaxDeleteGroup(data)
	}
}

function ajaxDeleteGroup(data){
	$.ajax({
		type: "DELETE",
		url:"http://localhost:8080/api/memberGroup/delete/"+data,
//		data:data,
//		dataType: "json",
		contentType:"application/json"
	}).done(function (response){
		alert("Xóa thành công");
		console.log("success");
		window.location.href="http://localhost:8080/groupMember";
	}).fail(function(response){
		console.log("fail");
        alert(response);
        window.location.href="http://localhost:8080/groupMember";
    
	});
}

function editGroup(data){
	getById(data);
	openModalEdit();
}
function openModalEdit(){
	$('#editModal').modal();
}
function getById(data){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/memberGroup/"+data,
		dataType: "json",
		contentType:"application/json"
	}).done(function (responseData){
		object = responseData;
		 bindingFormEdit(responseData);
         console.log(object);
	}).fail(function(response){
		console.log("fail");
        console.log(response);
	});
}
function bindingFormEdit(data){
	$('#idgr').val(data.id);
	$('#codegr').val(data.code);
	$('#namegr').val(data.name);
	
}


function assigmentGroup(data){
	getGroupMember(data);
	openGroupModal();
}
function openGroupModal(){
	$('#authorModal').modal({show : true});
}
function getGroupMember(data){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/memberGroup?code="+data,
		dataType: "json",
		contentType:"application/json"
	}).done(function (responseData){
		object = responseData;
		 bindingObjectGroup(responseData);
         console.log(object);
	}).fail(function(response){
		console.log("fail");
        console.log(response);
	});
}

function bindingObjectGroup(data){
	var memberGroup = data;
	document.getElementById("titleModdal").innerHTML="Phân quyền cho nhóm "+ memberGroup.code;
	var show = '';
	show+='<ul class =" list-unstyled text-link itemPermiss permissId">';
	$(data.permissons).each(function(index,v){
		show+='<div>';
		show+='<li class="">';
		show+='<div  class="permissId">';
		show+='<input type="checkbox" class="permissId" id="'+v.code+'p" onchange="changePermiss(this)" value="'+v.id+'" '+v.checked+'>';
		show+='<a class="dropdown-toggle text-link"  data-toggle="collapse"  href="#p'+v.code+'"  aria-expanded="true">';
		show+='<span class="">'+v.name+'</span></a>';
		show+='</div>';
		show+='<div id="p'+v.code+'" class="collapse"  >';
		show+='<ul class="actionId list-unstyled ml-3">';
		$(v.actions).each(function(index2, v2){
			
			show+='<li class="">';
			show+='<div class="actionId">';
			show+='<input type="checkbox" class="'+v.code+'p" onchange="changeAction(this)" id="'
				+v2.code+'a" value="'+v2.id+'" '+v2.checked+'>';
			show+='<a href="#a'+v2.code+'" class="dropdown-toggle text-link" data-toggle="collapse"  >' +v2.name+'</a>';
			show+='</div>';
			show+='<div id="a'+v2.code+'" class="collapse">';
			show+='<ul class="actionDetail list-unstyled ml-5">';
			$(v2.actiondetails).each(function(index3, v3){
				show+='<li>';
				show+='<div class="actionDetail">';
				show+='<input class="actionDetail '+v.code+'p '+v2.code+'a" id="c'+v3.code+'"  type="checkbox" value="'+v3.id+'"'+v3.checked+'>'+v3.name;
				show+='</div>';
				show+='</li>';
			})
			show+='</ul>';
			show+='</div>';
			show+='</li>';
		})
		show+='</ul>';
		show+='</div>';
		show+='</li>';
		show+='</div>';
	})
	show+='</ul>';
	show+='<input type="hidden" id="codeGroup" value="'+data.code+'">';
		
	$('#listPermiss').empty();
    $('#listPermiss').append(show);
	
}

function changePermiss(object){
	var data = object;
	console.log(data.id);
	if($('#'+data.id).prop('checked')==true){
		$('input.'+data.id).prop('checked',true);	
	}else{
		$('input.'+data.id).prop('checked',false);
	}
		
}
function changeAction(object){
	var data = object;
	console.log(data.id);
	if($('#'+data.id).prop('checked')==true){
		$('input.'+data.id).prop('checked',true);	
	}else{
		$('input.'+data.id).prop('checked',false);
	}
}
function saveChange(){
	var actionDetailIds =$('.actionDetail input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    var actionIds =$('.actionId ').find('.actionId input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    var permiss =$('.permissId ').find('.permissId input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    var data = {};
    var codeGroup = $('#codeGroup').val();
    data['code'] = codeGroup;
    data['actionDetailList'] = actionDetailIds;
    data['actionList'] = actionIds;
    data['permissList'] = permiss;
    console.log(data);
    
    assignmentRoleGroup(data);
    
}

function assignmentRoleGroup(data){
	$.ajax({
		type: "PUT",
		url:"http://localhost:8080/api/memberGroup/assigment",
		data: JSON.stringify(data),
//		dataType: "json",
		contentType:"application/json"
	}).done(function (responseData){
		alert("Phân quyền thành công");
        console.log(responseData);
        $("#authorModal").modal("hide");
	}).fail(function(response){
		console.log("fail");
       console.log(response);
	});
}

function search(){
	var code = $('#searchcode').val();
	var searchname = $('#searchname').val();
	console.log(code);
	console.log(searchname);
	getByCodeAndName(code, searchname);
}
function getByCodeAndName(code,name){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/memberGroup/search?code="+code+"&name="+name,
//		dataType: "json",
		contentType:"application/json"
	}).done(function (responseData){
		object = responseData;
		 bindingTable(responseData);
         console.log(object);
	}).fail(function(response){
		console.log("fail");
        console.log(response);
	});
}

function bindingTable(data){
	var table = $('#example').DataTable();
	table.clear().draw();
	
	
	
	var show = '';
	$(data).each(function(index,v){
		show+='<tr><td>'+(index+1)+'</td>';
		show+='<td>'+v.code+'</td>';
		show+='<td>'+v.name+'</td>';
		show+='<td>';
		show+='<button class="btn btn-success btn-sm" title="Sửa" onclick="editGroup('+v.id+')" data-toggle="tooltip"><i class="fa fa-edit"></i></button>';
		show+='<button class="btn btn-danger btn-sm" title="Xóa" onclick="deleteGroup('+v.id+')" data-toggle="tooltip"><i class="fa fa-trash"></i></button>';
		show+='<button class="btn btn-warning btn-sm" title="Phân quyền" onclick="assigmentGroup('+v.id+')" data-toggle="modal"><i class="fa fa-list-alt"></i></button>';
		show+='</td>';
		show+='</tr>';
		
	});
	table.rows.add($(show)).draw();
}



