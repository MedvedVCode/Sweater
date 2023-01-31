<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
        <div>
            <@l.logout />
            <span><a href="/user"> User list </a> </span>
        </div>
        <div>
            <form method="post">
                <input type="text" name="text" placeholder="Enter message's text">
                <input type="text" name = "tag" placeholder="Enter message's tag">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Add message</button>
            </form>
        </div>
        <div>
            <form method="get" action="main">
                <input type="text" name="filter" value="<#if filter??>${filter}</#if>">
                <button type="submit">Filter by Tag</button>
            </form>
        </div>
        <div> Message list:</div>
        <#list messages as message>
            <div>
                <b>${message.id}</b>
                <span>${message.tag}</span>
                <i>${message.text}</i>
                <strong>${message.authorName}</strong>
            </div>
            <#else >
            No messages
        </#list>
</@c.page>