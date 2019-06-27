
<#macro View view >
</#macro>
<#macro Widget id width height >
<#if id??>android:id="@+id/${id}"</#if>
<#if width??>android:width="${width}px"</#if>
<#if height??>android:height="${height}px"</#if>
</#macro>

<#macro Text text="" textSize="" textColor="" >
<#if text??>android:text="${text}"</#if>
<#if textSize??>android:textSize="${textSize}sp"</#if>
<#if textColor??>android:textColor="${textColor}"</#if>
</#macro>

<#if children??>
    <#list children as view>
        <#assign type>${view.type!}</#assign>
        <TextView
        <@Widget id="${view.id!}" width="${view.width!}" height="${view.height!}" />
        <@Text text="${view.text!}" textSize="${view.textSize!}" textColor="${view.textColor!}" />
        />
    </#list>
</#if>

