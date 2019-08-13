# scala-play-github-oauth-demo

This is a Scala Play Framework web app to give an example of how to login via GitHub OAuth Authentication.

:arrow_down: not logged-in (You cannot view *secret page*.)

![logged_out](https://user-images.githubusercontent.com/36184621/62938883-e86e3d80-be0a-11e9-868d-c2a21b9baa5c.png)

:arrow_down: logged-in (You can view *secret page*.)

![logged_in](https://user-images.githubusercontent.com/36184621/62938905-f4f29600-be0a-11e9-95cb-df6e5c4a39a1.png)

**Live Demo on Heroku: https://scala-github-oauth-demo.herokuapp.com/**

## test locally

```
git clone https://github.com/7ma7X/scala-play-github-oauth-demo.git
cd scala-play-github-oauth-demo 
```

Get your GitHub Client ID & Secret (https://github.com/settings/developers). Please make sure that *Authorization callback URL* is fixed to **`http://localhost:9000/oauth_callback`**.   
Set `demoapp.client_id` and `demoapp.client_secret` in `conf/application.conf` respectively.

After that

```
sbt run
```

and check http://localhost:9000.