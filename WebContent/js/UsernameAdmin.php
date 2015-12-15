if($frm_action == 'check') 
{ 
$userName = $_GET['name']; 
$userAdminObj = new Services_GradeAdmin($db); 
//根据$userName去判断是否再数据库里存在填入的用户名字，如果存在返回1，如果 
//不存在返回0，这个返回值是传到username_repeat.js里。 
$userCheck = $userAdminObj->getUserByUserName($userName); 
if(is_numeric($userCheck)){ 
echo '1'; 
}else{ 
echo '0'; 
} 
exit(); 
}