# scala-play-github-oauth-demo

This is a Scala Play Framework web app to give an example of how to login via GitHub OAuth Authentication.
<br>

(A detailed explanation in Japanese: [Scala + PlayFramework + pac4j での GitHub ログインの実装](https://qiita.com/7ma7X/items/6853333a71437d76e898))

<br>

:neutral_face: not logged-in (You cannot view *secret page*.)

![logged_out](https://user-images.githubusercontent.com/36184621/62940199-01c4b900-be0e-11e9-8924-48b4934a57f9.png)

:smile: logged-in (You can view *secret page*.)

![logged_in](https://user-images.githubusercontent.com/36184621/62940212-0c7f4e00-be0e-11e9-8013-62dcc6804e8c.png)

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
