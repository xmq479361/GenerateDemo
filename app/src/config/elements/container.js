export default {
    name: "容器",
    type: "container",
    attrs: [
        {
            key: "height",
            type: "dimension",
            def: "100",
            name: "高度",
            unit: "px",
        },
        {
            key: "width",
            type: "dimension",
            def: "100",
            name: "宽度",
            unit: "px",
        },
        {
            key: "gravity",
            type: "gravity",
            def: "left",
            name: "浮动",
            unit: "",
        },
    ],
}