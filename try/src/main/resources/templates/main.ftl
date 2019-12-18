<#import "parts/common.ftl" as c>

<@c.page>

<div class="card-columns">
    <#list products as pr>
    <div class="card my-3">
        <div class="m-2">
            <span>${pr.title}</span>
        </div>
        <div class="card-footer text-muted">
            <strong>${pr.ownerName}</strong>
        </div>
    </div>
    <#else>
    No products
    </#list>
</div>
</@c.page>

