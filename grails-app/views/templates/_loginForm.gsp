<sec:ifNotGranted roles="ROLE_SUPERUSER">
  <sec:ifLoggedIn>
  <div class="btn-group pull-right">
    <g:link url="#" class="btn dropdown-toggle" data-toggle="dropdown">
      <i class="icon-user"></i>&nbsp;
      <sec:loggedInUserInfo field="username"></sec:loggedInUserInfo>&nbsp;<b class="caret"></b>
    </g:link>
    <ul class="dropdown-menu">
      <li><g:link controller="logout" action="index"><i class="icon-off"></i>&nbsp;Logout</g:link></li>
          <li class="divider"></li>
          <li><g:link action="#"><i class="icon-key"></i>&nbsp;Change Password</g:link></li>
          <li><g:link action="#"><i class="icon-cogs"></i>&nbsp;Profile</g:link></li>
      </ul>
    </li>
  </sec:ifLoggedIn>
  <sec:ifNotLoggedIn>
    <li><g:link controller="login" action="index">Login</g:link></li>
  </sec:ifNotLoggedIn>
</sec:ifNotGranted>
