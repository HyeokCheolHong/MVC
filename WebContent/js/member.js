/**
 * member.js
 */
 
 function join_check() {
 	if($.trim($("#mem_id").val()) == "") {
 		alert("아이디를 입력하세요!");
 		$("#mem_id").val("").focus();
 		
 		return false;
 	}
 	
 	let mem_pwd = $.trim($("#mem_pwd").val());
 	$pwd_chk = $.trim($("#pwd_chk").val());
 	if(mem_pwd.length == 0) {
	 	alert("비밀번호를 입력하세요!");
	 	$("#mem_pwd").val("").focus();
	 	
	 	return false;
 	}
 	
 	if($pwd_chk == "") {
 		alert("비밀번호 확인을 입력하세요!");
 		$("#mem_chk").val("").focus();
 		
 		return false;
 	}
 	
 	if(mem_pwd != $pwd_chk) {
 		alert("비밀번호가 동일하지 않습니다!");
 		$("#mem_pwd").val("").focus();
 		$("#pwd_chk").val("");
 		
 		return false;
 	}
 	
 	if($.trim($("#mem_name").val()) == "") {
		alert("회원 이름을 입력하세요!");
		$("#mem_name").val("").focus();
		
		return false;
 	}
 	
 	if($.trim($("#phone02").val()) == "") {
 		alert("폰번호를 입력하세요!");
 		$("#phone02").val("").focus();
 		
 		return false;
 	}
 	
 	if($.trim($("#phone03").val()) == "") {
 		alert("폰번호를 입력하세요!");
 		$("#phone03").val("").focus();
 		
 		return false;
 	}
 	
 	if($.trim($("#mem_email").val()) == "") {
 		alert("이메일 주소를 입력하세요");
 		$("#mem_email").val("").focus();
 		
 		return false;
 	}
 	
 }