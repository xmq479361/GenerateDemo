import random

from jinja2 import FileSystemLoader, Environment

from com.xmq.react import PATH_LAYOUT


def get_with_def(data, key, default=""):
    result = default
    if data is not None:
        result = data.get(key, default)
    return result



    # <View style={{
    #       flex: 1,
    #       flexDirection: 'column',
    #       justifyContent: 'space-between',
    #     }}>
    #       <View style={{width: 50, height: 50, backgroundColor: 'powderblue'}} />
    #       <View style={{width: 50, height: 50, backgroundColor: 'skyblue'}} />
    #       <View style={{width: 50, height: 50, backgroundColor: 'steelblue'}} />
    #     </View>


class Config:
    # def __init()
    styles = {}

    def addStyle(self, style):
        if style is None:
            return
        # self.styles.append(style)
        self.styles.update(style)

    def getStyles(self):
        return self.styles
    def get_style_if_exsit(self, style):
        style_sr = str(style)
        for style in self.styles:
            style_exist = str(self.styles.get(style))
            if style_exist == style_sr:
                print("get_style_if_exsit: "+str(style))
                return style

        return None
class BaseWidget(object):
    def __init__(self, data, config=None):
        if config is None:
            config = Config()
        self.config = config
        self.data = data
        self.style_str = {}

    @staticmethod
    def append(base_data=None, key="", value=None):
        if base_data is None:
            base_data = {}
        if value is not None and value is not "":
            # if value.isdigit():
            #     base_data.update({key: int(value)})
            # else:
            base_data.update({key: value})
        return base_data

    # def append(self, key, inputkey, default=""):
    #     if self.data is not None:
    #         return append(self.style_str, inputkey, self.data.get(key, default))
    #     return self.style_str

    # def append_style(self, key, inputkey, default=""):
    #     if self.data is not None:
    #         return append(self.style_str, inputkey, self.data.get(key, default))
    #     return self.style_str
    def append_style(self, key, default=""):
        if self.data is not None:
            return BaseWidget.append(self.style_str, key, self.data.get(key, default))
        return self.style_str

    def append_style_with_link(self, key, default=None):
        if self.data is not None:
            value = self.data.get(key, default)
            if value is not None and value is not "":
                return BaseWidget.append(self.style_str, key, '"'+value+'"')
        return self.style_str

    def append_style_with(self, inputkey, key, default=""):
        if self.data is not None:
            return BaseWidget.append(self.style_str, inputkey, self.data.get(key, default))
        return self.style_str

    def render(self, temp_name, data_map=None):
        if data_map is None:
            data_map = {}
        template_env = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        template = template_env.get_template(temp_name)
        data = data_map
        return template.render(data)
        # tag_name = data_map.pop("Tag","View")
        # # style = data_map.pop("style")
        # content = data_map.pop("content")
        # inline_attrs=""
        # for key,value in data_map.items():
        #     inline_attrs +="%s={"%(key)+ value.replace('"','')+"}"
        # print("inline_attrs::", inline_attrs)
        # return"<%s %s >%s</%s>"%(tag_name, inline_attrs, content,tag_name)

        # < {{Tag}}
        # { % if style != '' %}style = {{{style}}}
        # { % endif %} { %
        # for key, value in attrs %}{% if value != '' %}{{key}}={{{value}}}{% endif %}{% endfor %} > {{content}} < / {{Tag}} >

    def get_content_generate(self, parent_direction):
        return ""

    def get_with_def(self, key, default=None):
        return self.data.get(key, default)

    def get_attrs(self, parent_direction, curr_direction):
        self.style_str = self.build_default_style(parent_direction, curr_direction)
        return {'style': self.style_str}

    def get_style_build(self, attrs):
        type = self.get_with_def('type', 'style')
        widget_style = attrs.pop('style', None)
        if widget_style is None:
            return ''
        else:
            style_name = self.config.get_style_if_exsit(widget_style)
            if style_name is None:
                style_name = '%s%d' % (type, int(random.random() * 999999))
                self.config.addStyle({style_name: widget_style})
            return 'styles.%s' % style_name

    def generate(self, parent_direction, curr_direction=None):
        if curr_direction is None:
            content = self.get_content_generate(parent_direction)
        else:
            content = self.get_content_generate(curr_direction)
        attrs = self.get_attrs(parent_direction, curr_direction);
        real_style = self.get_style_build(attrs)
        return self.render(self.render_name(), {"Tag": self.render_tag_name(),
                                                # 'style': self.build_default_style(),
                                                'style': real_style,
                                                'attrs': attrs.items(),
                                                "content": content}
                           # .update(real_style)
                           )

    def render_name(self):
        return "widget.html"

    def render_tag_name(self):
        return "View"

    def build_default_style(self, parent_direction, current_direction=None):
        width = get_with_def(self.data, 'width', "100")
        height = get_with_def(self.data, 'height', "100")
        is_vertical = parent_direction is 'column' or parent_direction is 'column-reverse'
        # is_same_direction = current_direction == parent_direction
        if str(width).find("px") >= 0:
            BaseWidget.append(self.style_str, 'width', int(width.replace('px', "")))
        elif width.isdigit():
            if not is_vertical:
                self.append_style('flexGrow', int(width))
        else:
            # print("build_default_style >>>else ", is_vertical, width.find("px"), width, 'x', height)
            if is_vertical:
                self.append_style_with_link('alignSelf', "stretch")
                # elif width.endswith("%"):
                #     # self.append_style( 'alignSelf', "stretch")
                #     pass
                # else:
                #     self.append_style('width', int(width))
        if height.find("px") >= 0:
            # # self.append_style('height', int(height.replace("px", "")))
            # pass
            # BaseWidget.append(self.style_str, 'height', height.replace('px', " * ratio"))
            BaseWidget.append(self.style_str, 'height', height.replace('px', ""))
        elif height.isdigit():
            if is_vertical:
                self.append_style('flexGrow', height)
        else:
            if not is_vertical:
                self.append_style_with_link('alignSelf', "stretch")
                # elif height.endswith("%"):
                # self.append_style( 'flex', "1")flexGrow:0,
                # pass
            else:
                if int(height) == -1:
                    # self.append_style('height', int(height))
                    self.append_style('flexGrow', 0)
                else:
                    # PixelRatio.getPixelSizeForLayoutSize(200)
                    self.append_style('height', int(height))
                    # self.append_style('height', height+"*radio")
                    pass
        margin = self.get_with_def("margin")
        if margin is not None:
            margin_group = margin.replace('px', "").split(" ")
            if len(margin_group) ==2:
                BaseWidget.append(self.style_str, 'marginVertical', margin_group[0])
                BaseWidget.append(self.style_str, 'marginHorizontal', margin_group[1])
            else:
                BaseWidget.append(self.style_str, 'margin', margin_group[0])
        padding = self.get_with_def("padding")
        if padding is not None:
            padding_group = padding.replace('px', "").split(" ")
            if len(padding_group) ==2:
                BaseWidget.append(self.style_str, 'paddingVertical', padding_group[0])
                BaseWidget.append(self.style_str, 'paddingHorizontal', padding_group[1])
            else:
                BaseWidget.append(self.style_str, 'padding', padding_group[0])
        self.append_style_with_link("backgroundColor", self.get_with_def("background"))
        return self.style_str
