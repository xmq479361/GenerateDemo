<#include "layout_marco.ftl">
<#if view??><#assign type>${view.type!}</#assign>
<#include "${type}.ftl">
${typeFront}
    <@Widget id="${view.id!}" width="${view.width!}" height="${view.height!}" />
    <@Text text="${view.text!}" textSize="${view.textSize!}" textColor="${view.textColor!}" />
${typeSuffix}
</#if>
