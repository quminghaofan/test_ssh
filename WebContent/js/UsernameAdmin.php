if($frm_action == 'check') 
{ 
$userName = $_GET['name']; 
$userAdminObj = new Services_GradeAdmin($db); 
//����$userNameȥ�ж��Ƿ������ݿ������������û����֣�������ڷ���1����� 
//�����ڷ���0���������ֵ�Ǵ���username_repeat.js� 
$userCheck = $userAdminObj->getUserByUserName($userName); 
if(is_numeric($userCheck)){ 
echo '1'; 
}else{ 
echo '0'; 
} 
exit(); 
}