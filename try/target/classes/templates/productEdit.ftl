<#import "parts/common.ftl" as c>

<@c.page>
<form action="/product" method="post">
    <input type="text" name="title" value="${product.title}">

    <input type="hidden" value="${product.id}" name="productId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>