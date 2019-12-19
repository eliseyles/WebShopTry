<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-2">Add new user</div>
<#if message??>
<div class="alert alert-danger" role="alert">
    ${message}
</div>
</#if>
<@l.login "/registration" true />
</@c.page>