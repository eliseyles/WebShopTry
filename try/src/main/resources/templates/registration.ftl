<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>Add new user</div>
<div>${(message)!"\n"}</div>
<@l.login "/registration" />
</@c.page>