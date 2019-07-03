import random

from jinja2 import FileSystemLoader, Environment

from com.xmq.Config import WidgetConfig
from com.xmq.react import PATH_LAYOUT
from com.xmq.react.ReactAttributes import ReactAttrMapper


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


class BaseWidget(object):
    def __init__(self, data, config=None):
        if config is None:
            config = WidgetConfig()
        self.data = data
        self.config = config.get_child_widget_config(data)
        self.style_str = {}

    @staticmethod
    def append(base_data=None, key="", value=None):
        if base_data is None:
            base_data = {}
        if value is not None and value is not "":
            base_data.update({key: value})
        return base_data

    def append_style(self, key, default=""):
        if self.data is not None:
            return BaseWidget.append(self.style_str, key, self.data.get(key, default))
        return self.style_str

    def append_style_with_link(self, key, default=None):
        if self.data is not None:
            value = self.data.get(key, default)
            if value is not None and value is not "":
                return BaseWidget.append(self.style_str, key, '"' + value + '"')
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
            # TODO 判断是否存在已有样式
            style_name = self.config.get_style_if_exsit(widget_style)
            if style_name is None:
                style_name = '%s%d' % (type, int(random.random() * 999999))
                self.config.addStyle({style_name: widget_style})
            return 'styles.%s' % style_name

    def generate(self, parent_direction, curr_direction=None):
        # TODO 获取到子元素以及正文内容
        if curr_direction is None:
            content = self.get_content_generate(parent_direction)
        else:
            content = self.get_content_generate(curr_direction)
        self.attribute_mapper.mapper(self.data, self.config)
        # TODO 获取组件各种样式属性
        # attrs = self.get_attrs(parent_direction, curr_direction);
        attrs = self.config.get_attributes()

        data_map = {"Tag": self.render_tag_name(), 'attrs': attrs.items(), "content": content}
        style_value = self.get_style_build(attrs)
        if style_value is not None and style_value is not '':
            data_map.update({'style': style_value})
        return self.render(self.render_name(), data_map)

    def render_name(self):
        return "widget.html"

    def render_tag_name(self):
        return "View"

    attribute_mapper = ReactAttrMapper()

