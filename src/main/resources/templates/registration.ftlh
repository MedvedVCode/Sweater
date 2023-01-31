<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    Add new user:
    <#if message??>${message}</#if>
    <@l.login "/registration" />
</@c.page>