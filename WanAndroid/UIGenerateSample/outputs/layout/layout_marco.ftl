<#macro View view ></#macro>
<#macro Widget id width height>
    <#if id!="">android:id="@+id/${id}"
    </#if><#if width=="0">android:width="wrap_content"
    <#else>android:width="${width}px"
    </#if>
<#if height=="0">android:height="wrap_content"
    <#else>android:height="${height}px"
</#if>
</#macro>
<#macro Text text="" textSize="" textColor="" >
<#if text!="">android:text="${text}"
    </#if><#if textSize!="0" && textSize!="">android:textSize="${textSize}sp"
    </#if><#if textColor!="">android:textColor="${textColor}"</#if></#macro>
