
<#list children as value>
    <#if value??>
        <#include "${value.type}.ftl" />
    </#if>
</#list>