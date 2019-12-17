<#import "parts/common.ftl" as c>

<@c.page>
List of users
<tbody>
    <thead>
    <div>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </div>
    </thead>
    <tbody>
<#list users as user>
    <div>
        <td>${user.username}</td>
        <td><#list (user.roles)! as role>${(role)!}<#sep>, </#list></td>
        <td> <a href = "/user/${user.id}">edit</a> </td>
    </div   >
</#list>
    </tbody>>
</table>
</@c.page>