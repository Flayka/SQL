0. Put all your project in `C:\Users\Idea` (not anywhere else)
1. Start from scratch: in the console - `docker-machine start` (only if it not started)
2. Recheck ip: `docker-machine ip` (it may be not 192.168.99.100)
3. If in step 2, ip is not 192.168.99.100 use `docker-machine env` (copy and paste output to console)
4. Start docker-compose: `docker-compose up`
5. If it warns about certificates with different ip (x.x.x.101) use `docker-machine provision`
6. Wait, it slow on your pc
7. After all work `docker-machine stop`

My fault it's use old path
