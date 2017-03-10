1用户注册
客户单选择‘用户注册’，提示要输入用户名，密码，确认密码，校验成功后将用户
信息保存到数据库，并提示数据库注册成功，请登录

2用户登录
客户端选择‘登录以后’后，提示输入用户名和密码，验证成功则提示上传文件
，验证失败则给出提示信息，并可以重新登录

3文件上传
客户端输入上传文件的路径，并读取文件数据，通过输出流发送到服务端，服务端接受
后将上传文件保持在数据库


建表语句
CREATE TABLE tb_user
(	
	id INT auto_increment PRIMARY KEY,
	username VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(30)
);

CREATE TABLE tb_file
(	
	fid INT auto_increment PRIMARY KEY,
	fname VARCHAR(50) NOT NULL ,
	fcontent BLOB
)