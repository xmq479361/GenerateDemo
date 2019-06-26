export default {
    name: "文本",
    type: "text",
    attrs: [
        {
            desc: "height",
            type: "dimension",
            def: "100",
            name: "高度",
            unit: "px",
        },
        {
            desc: "width",
            type: "dimension",
            def: "100",
            name: "宽度",
            unit: "px",
        },
        {
            desc: "gravity",
            type: "gravity",
            def: "left",
            name: "浮动",
            unit: "",
        },
        {
            desc: "text",
            type: "string",
            def: "",
            name: "文本内容",
            unit: "",
        },
        {
            desc: "placeholder",
            type: "string",
            def: "",
            name: "提示文字",
            unit: "",
        },
    ],
}