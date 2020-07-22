/*validate*/

$(document).ready(function(){
	$("#addEmployee").validate({
		rules: {
			id: "required",
			fullname: "required",
			idcard: {
				
			},
			email:{
				 required: true,
	              email: true
			},
			phonenumber:{
				digits:true,
				minlength: 5
			},
			address:{
				
				minlength: 5
			}
		},
		messages:{
			id: "Không bỏ trống trường này",
			fullname: "Vui lòng nhập họ tên",
			idcard:{
				
				minlength: "Nhập ít nhất 5 kí tự"
			}, 
			email:"Vui lòng nhập email của bạn",
			phonenumber:"Vui lòng nhập số điện thoại của bạn",
			address:{
				
				minlength: "Nhập ít nhất 5 kí tự"
			}
			
		},
		 submitHandler: function (form) { // for demo
	            
	            return false;
	        }
	});
	 $('#btnAddEmp').on('click', function () {
	        if($('#addEmployee').valid()){
	        	var data={};
	            var formData = $('#addEmployee').serializeArray();
	            $.each(formData,function (index,v) {
	                data[""+v.name+""] = v.value;
	            });
	            console.log(data);
	            var id = $('#idcheck').val();
	            if(id==""){
	            	saveEmployee(data);
	            }else{
	            	updateEmployee(data);
	            }
	            
	        }
	    });
});

function saveEmployee(data){
	$.ajax({
		type:"POST",
		url: "http://localhost:8080/api/employees",
		data: JSON.stringify(data),
		
		contentType:"application/json"
	}).done(function (response){
		alert("Thêm thành công");
		console.log("success");
		
		window.location.href="http://localhost:8080/employees";
	}).fail(function(response){
		console.log("fail");
        alert(response.message);
       
	});
}
function updateEmployee(data){
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/api/employees",
		data: JSON.stringify(data),
		
		contentType:"application/json"
	}).done(function (response){
		alert("Sửa thành công");
		console.log("success");
		window.location.href="http://localhost:8080/employees";
	}).fail(function(response){
		console.log("fail");
        alert(response.message);
       
	});
}
function detailById(data){
	getById2(data);
	openModalEdit();
	$('#titleModal').text('Chi tiết nhân viên');
	$('#btnAddEmp').hide();
}
function updateById(data){
	getById(data);
	openModalEdit();
	$('#titleModal').text('Sửa thông tin nhân viên');
}

function openModalEdit(){
	$('#editemployee').modal();
}
function getById(data){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/employees/"+data,
		
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
function getById2(data){
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/employees/"+data,
		
		contentType:"application/json"
	}).done(function (responseData){
		object = responseData;
		 bindingFormEdit2(responseData);
         console.log(object);
	}).fail(function(response){
		console.log("fail");
        console.log(response);
	});
}
function bindingFormEdit(data){
	$('#idcheck').val(data.id);
	$('#id').val(data.id);
	$('#id').prop('readonly', true);
	$('#status').val(data.status);
	$('#fullname').val(data.fullname);
	$('#datepicker').val(data.dateOfBirth);
	$('#typeidcard').val(data.typeidcard);
	$('#idcard').val(data.idcard);
	$('#email').val(data.email);
	$('#phonenumber').val(data.phonenumber);
	$('#gender').val(data.gender);
	$('#address').val(data.address);
}
function bindingFormEdit2(data){
	$('#idcheck').val(data.id);
	$('#id').val(data.id);
	$('#id').prop('readonly', true);
	$('#status').val(data.status);
	$('#status').prop('disabled', true);
	$('#fullname').val(data.fullname);
	$('#fullname').prop('readonly', true);
	$('#datepicker').val(data.dateOfBirth);
	$('#datepicker').prop('readonly', true);
	$('#typeidcard').val(data.typeidcard);
	$('#typeidcard').prop('disabled', true);
	$('#idcard').val(data.idcard);
	$('#idcard').prop('readonly', true);
	$('#email').val(data.email);
	$('#email').prop('readonly', true);
	$('#phonenumber').val(data.phonenumber);
	$('#phonenumber').prop('readonly', true);
	$('#gender').val(data.gender);
	$('#gender').prop('disabled', true);
	$('#address').val(data.address);
	$('#address').prop('readonly', true);
}

function deleteById(data){
if(confirm("Xác nhận xóa")){
		
		ajaxDeleteGroup(data)
	}
}
function ajaxDeleteGroup(data){
		$.ajax({
			type: "DELETE",
			url:"http://localhost:8080/api/employees/delete/"+data,
//			data:data,
//			dataType: "json",
			contentType:"application/json"
		}).done(function (response){
			alert("Xóa thành công");
			console.log("success");
			window.location.href="http://localhost:8080/employees";
		}).fail(function(response){
			console.log("fail");
	        alert(response);
	          
		});
	
}