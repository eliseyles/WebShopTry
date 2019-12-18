<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Kyfar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Products</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User List</a>
            </li>
            </#if>
        <li class="nav-item">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by title">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </li>
        </ul>
    </div>
    <#if isUser>
    <div>
        <form action="/adding" >
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-primary mr-4" type="submit" >добавить говно</button>
        </form>
    </div>
    </#if>
    <div class="navbar-text mr-4">${name}</div>

    <#if isUser>
    <@l.logout true/>
    <#else>
    <@l.logout false/>
    </#if>
</nav>