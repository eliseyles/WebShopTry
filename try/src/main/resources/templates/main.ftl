<#import "parts/common.ftl" as c>

<@c.page>
<div class="card-columns">
    <#list products as pr>
    <div class="card my-3">
        <div class="card-body">
            <h5 class="card-title">${pr.title}</h5>
            <p class="card-text">${(pr.description)!}</p>
        </div>
        <div class="card-footer text-muted">
            <strong>${pr.ownerName}</strong>
            <h6 class="card-text">${(pr.price)!}</h6>
        </div>
    </div>
    <#else>
    No products
    </#list>
</div>
</@c.page>

