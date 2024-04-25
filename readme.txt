1). How to install Redis in Windows (as Redis is not for windows)
https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/#install-redis
https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/

a). Run Windows PowerShell as adminstrator  (or go to Windows Feature turn OF and ON and chek)
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux

b). start ms-windows-store:
c). Search for Ubuntu (select windows version for developer)
d). When download completed, click on open button (in Microsoft Store).
e). create user and password
f). install redis 
  i). sudo apt-add-repository ppa:redislabs/redis
 ii). sudo apt-get update
 iii).sudo apt-get install redis-server
g). redis-cli --version
h). sudo service redis-server restart
i). redis-cli   (127.0.0.1:6379/ ctr+c to ubunto root)
j). sudo service redis-server status

2). Monitor Redis Server when using API
a). type redis-cli
b). monitor 


3). After stopping/closing Ubuntu, it is requried to run it as adminstrator (from the windows start)
and, and then run sudo service redis-server restart (sudo service redis-server restart) and check the 
status (sudo service redis-server status)

a). sudo service redis-server stop (root ubuntu)