from com.xmq.react.ReactTemplate import ReactTemplate
from com.xmq.web.WebTemplate import WebTemplate

data = {
    "type": "page",
    "display": "flex",
    "flex_direction": "column",
    "justify_content": "flex-start",
    "align_items": "flex-start",
    "background": "#FFFFCF",
    "appBar": {
        "type": "container",
        "display": "flex",
        "flex_direction": "row",
        "justify_content": "space-between",
        "align_items": "center",
        "width": "100%",
        "height": "0",
        "background": "#CFAFFF",
        "padding": "5px",
        "children": [
            {
                "type": "container",
                "display": "flex",
                "flex_direction": "row",
                "width": "1",
                "height": "0",
                "children": [
                    {
                        "type": "icon",
                        "width": "32px",
                        "height": "32px",
                        "src": "ico_back.webp",
                    },
                ]
            },
            {
                "type": "text",
                "width": "0",
                "height": "1",
                "text": "新建日程",
            },
            {
                "type": "container",
                "display": "flex",
                "flex_direction": "row",
                "justify_content": "flex-end",
                "width": "1",
                "height": "1",
                "children": [
                    {
                        "type": "icon",
                        "width": "32px",
                        "height": "32px",
                        "src": "ico_back.webp",
                    },
                    {
                        "type": "icon",
                        "width": "32px",
                        "height": "32px",
                        "src": "ico_back.webp",
                    },
                ]
            },
        ]
    },
    "body": {
        "type": "container",
        "display": "flex",
        "flex_direction": "column",
        "justify_content": "flex-start",
        "align_items": "flex-start",
        "width": "10",
        "height": "10",
        "background": "#FFFFFF",
        "margin": "5px",
        "children": [
            {
                "type": "input",
                "width": "100%",
                "height": "50px",
                "hint": "请输入日程主题",
                "margin": "5px",
                "textSize": "15",
                "textColor": "#545454",
                "textStyle": "bold",
            },
            {
                "type": "input",
                "width": "100%",
                "height": "50px",
                "hint": "请输入日程内容",
                "margin": "5px 15px",
                "padding": "5px 15px",
                "textSize": "12",
                "textColor": "#545454",
            },
            {
                "type": "spaceView",
                "width": "100%",
                "height": "1px",
                "background": "#d8d8d8"
            },
            {
                "type": "container",
                "display": "flex",
                "flex_direction": "row",
                "justify_content": "space-between",
                "align_items": "flex-start",
                "width": "100%",
                "height": "100px",
                "children": [
                    {
                        "type": "container",
                        "display": "flex",
                        "flex_direction": "column",
                        "justify_content": "center",
                        "align_items": "center",
                        "width": "5",
                        "height": "100%",
                        "children": [
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "开始",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "2019/06/28 15:00",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                        ]
                    },
                    {
                        "type": "spaceView",
                        "height": "100%",
                        "width": "1px",
                        "background": "#b7d0d0"
                    },
                    {
                        "type": "container",
                        "display": "flex",
                        "flex_direction": "column",
                        "justify_content": "center",
                        "align_items": "center",
                        "width": "5",
                        "height": "100%",
                        "children": [
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "结束",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "2019/06/28 16:00",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                        ]
                    },
                    {
                        "type": "spaceView",
                        "height": "100%",
                        "width": "1px",
                        "background": "#b7d0d0"
                    },
                    {
                        "type": "container",
                        "display": "flex",
                        "flex_direction": "column",
                        "justify_content": "center",
                        "align_items": "center",
                        "width": "5",
                        "height": "100%",
                        "children": [
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "结束22",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                            {
                                "type": "text",
                                "width": "5",
                                "height": "-1",
                                "text": "2019/06/28 16:00",
                                "textSize": "12",
                                "textColor": "#545454",
                            },
                        ]
                    },
                ]
            },
            {
                "type": "spaceView",
                "height": "20px",
                "width": "100%",
                "background": "#37d0d0"
            },
            {
                "type": "container",
                "display": "flex",
                "flex_direction": "row",
                "justify_content": "space-between",
                "align_items": "flex-start",
                "width": "100%",
                "height": "50px",
                "children": [
                    {
                        "type": "icon",
                        "width": "32px",
                        "height": "32px",
                        "src": "event/ico_event_tag.png",
                        "textSize": "12",
                        "textColor": "#545454",
                    },
                    {
                        "type": "input",
                        "width": "1",
                        "height": "32px",
                        "hint": "请输入标签",
                        "textSize": "12",
                        "textColor": "#545454",
                    },
                ],
            },
            # {
            #     "type": "container",
            #     "display": "flex",
            #     "flex_direction": "col",
            #     "justify_content": "space-between",
            #     "align_items": "flex-start",
            #     "width": "100%",
            #     "height": "50px",
            #     "children": [
            #         {
            #             "type": "input",
            #             "width": "1",
            #             "height": "32px",
            #             "hint": "请输入标签",
            #             "textSize": "12",
            #             "textColor": "#545454",
            #         },
            #     ],
            # },
            {
                "type": "button",
                "width": "100%",
                "height": "50px",
                "text": "提交",
                "textSize": "12",
                "textColor": "#545454",
                "bacckground": "#F45454",
            },
        ],
    }
}


def run():
    print("Main running")
    import sys
    # print(json.load(data));
    template = 'web'
    if sys.argv is not None and len(sys.argv)>1:
        template = sys.argv[1]
    print("进程执行。", sys.argv, template)
    # print(data)
    # template(data);
    # AndroidTemplate().generate(data)
    if template == 'react':
        ReactTemplate().generate(data)
    elif template == 'web':
        WebTemplate().generate(data)
