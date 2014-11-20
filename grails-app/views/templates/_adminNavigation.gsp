<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <g:link class="navbar-brand" controller="dashboard" action="index">Roombix</g:link>
  </div>
  <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">System <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><g:link controller="secUser" action="index">Show users</g:link></li>
                <li><g:link controller="admin" action="showStatistics">Show statistics</g:link></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Property <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><g:link controller="hotel" action="edit">Hotel</g:link></li>
                <li><g:link controller="room" action="index">Rooms</g:link></li>
                <li><g:link controller="roomCategory" action="index">Room Categrories</g:link></li>
                <li><g:link controller="reservation" action="index">Reservations</g:link></li>
            </ul>
        </li>
    </ul>
    <sec:ifLoggedIn>
      <g:render template="/templates/loginInfo"/>  
    </sec:ifLoggedIn>
  </div>
</nav><!-- /navbar -->    