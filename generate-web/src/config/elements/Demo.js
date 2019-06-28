export default {
    type: "container",
    display: "flex",
    flex_direction: "column",
    justify_content: "start",
    align_items: "start",
    width: "10",
    height: "10",
    background: "#FFFFFF",
    children: [
        {
            type: "text",
            width: "10",
            height: "50px",
            hint: "请输入日程主题",
            margin: "5,5,5,5",
            textSize: "15",
            textColor: "#545454",
            textStyle: "bold"
        },
        {
            type: "text",
            width: "10",
            height: "50px",
            hint: "请输入日程内容",
            margin: "5,5,5,5",
            textSize: "12",
            textColor: "#545454",
        },
        {
            type: "spaceView",
            width: "10",
            height: "1px",
            background: "#d8d8d8"
        },
        {
            type: "container",
            display: "flex",
            flex_direction: "row",
            justify_content: "space-between",
            align_items: "start",
            width: "10",
            height: "-1",
            children: [
                {
                    type: "container",
                    display: "flex",
                    flex_direction: "column",
                    justify_content: "center",
                    align_items: "center",
                    width: "5",
                    height: "100px",
                    children: [
                        {
                            type: "text",
                            width: "5",
                            height: "-1",
                            text: "开始",
                            textSize: "12",
                            textColor: "#545454",
                        },
                        {
                            type: "text",
                            width: "5",
                            height: "-1",
                            text: "2019/06/28 15:00",
                            textSize: "12",
                            textColor: "#545454",
                        },
                    ]
                },
                {
                    type: "spaceView",
                    width: "1px",
                    height: "10",
                    background: "#d8d8d8"
                },
                {
                    type: "container",
                    display: "flex",
                    flex_direction: "column",
                    justify_content: "center",
                    align_items: "center",
                    width: "5",
                    height: "100px",
                    children: [
                        {
                            type: "text",
                            width: "5",
                            height: "-1",
                            text: "结束",
                            textSize: "12",
                            textColor: "#545454",
                        },
                        {
                            type: "text",
                            width: "5",
                            height: "-1",
                            text: "2019/06/28 16:00",
                            textSize: "12",
                            textColor: "#545454",
                        },
                    ]
                },
            ]
        },
        {
            type: "spaceView",
            height: "20px",
            width: "1",
            background: "#b7d0d0"
        },
        {
            type: "container",
            display: "flex",
            flex_direction: "row",
            justify_content: "space-between",
            align_items: "start",
            width: "10",
            height: "100px",
            children: [
                {
                    type: "icon",
                    width: "32px",
                    height: "32px",
                    src: "ico_event_tag.png",
                    textSize: "12",
                    textColor: "#545454",
                },
                {
                    type: "input",
                    width: "1",
                    height: "32px",
                    hint: "请输入标签",
                    textSize: "12",
                    textColor: "#545454",
                },
            ],
        },
    ],
}
