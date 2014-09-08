<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <g:link class="navbar-brand" controller="superuser" action="index">Roombix</g:link>
  </div>
  <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
      <li><g:link controller="superuser" action="index">Licenses</g:link></li>
      <li><g:link controller="superuser" action="monitor">Monitor</g:link></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><g:link uri="/">Login</g:link></li>
    </ul>

    <sec:ifLoggedIn>
      <g:render template="/templates/loginInfo"/>  
    </sec:ifLoggedIn>
  </div>
</nav><!-- /navbar -->