<ul class="list-unstyled">
    <li>Feasible: ${plan?.score?.getFeasible()}</li>
    <li>Score: ${plan?.score?.getHard()}/${plan?.score?.getSoft()}</li>
</ul>
<ul class="list-unstyled">
    <li><g:link action="showCurrentPlan">Show plan...</g:link></li>
    <li><g:link action="showCurrentPlanSvg">Show plan SVG...</g:link></li>
    <li><g:link action="newConfiguration">New configuration</g:link></li>
</ul>