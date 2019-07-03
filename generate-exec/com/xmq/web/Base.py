from jinja2 import FileSystemLoader, Environment

from com.xmq.web import PATH_LAYOUT


def get_with_def(data, key, default=""):
    result = default
    if data is not None:
        result = data.get(key, default)
    return result


def append(base_data, key, value):
    if value is not None and value is not "":
        base_data += " %s: %s;" % (key, value)
    return base_data


class Config:
    def ioc_attrs(self, attrs):
        return attrs


# class UnknownWidgetConfig:
#     def __init__(self, config):
#         self.config = config
#
#     def ioc_attrs(self, attrs):
#         attrs.update("attr :background-color: red;"
#         return attrs

class BaseWidget(object):
    def __init__(self, data, config=None):
        if config is None:
            config = {}
        self.config = config
        self.data = data

    # @staticmethod
    # def unknown_widget_config(config):
    #     return UnknownWidgetConfig(config)

    def append(self, key, inputkey, default=""):
        if self.data is not None:
            return append("", inputkey, self.data.get(key, default))
        return ""

    def render(self, temp_name, data_map=None):
        if data_map is None:
            data_map = {}
        template_env = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        # TemplateEnv.filters['get_attrs', self.get_attrs]
        template = template_env.get_template(temp_name)
        data = data_map
        return template.render(data)

    def get_content_generate(self, parent_direction):
        return ""

    def get_with_def(self, key, default=""):
        return self.data.get(key, default)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        # display = get_with_def(self.data, 'display', "flex")
        # width = get_with_def(self.data, 'width', "100%")
        # height = get_with_def(self.data, 'height', "100%")
        # return self.data
        return {'style': style_str}

    def get_attrs_build(self, attrs):
            # '<div background="red" >' +
        if self.config and self.config.ioc_attrs:
            return self.config.ioc_attrs(attrs)
        return attrs

    def generate(self, parent_direction, curr_direction=None):
        if curr_direction is None:
            content = self.get_content_generate(parent_direction)
        else:
            content = self.get_content_generate(curr_direction)
        return self.render(self.render_name(), {"Tag": self.render_tag_name(),
                                                'attrs': self.get_attrs_build(self.get_attrs(parent_direction, curr_direction)).items(),
                                                "content": content})

    def render_name(self):
        return "widget.html"

    def render_tag_name(self):
        return "div"

    def build_default_style(self, parent_direction, current_direction=None):
        # style_str = "display: flex;"
        style_str = ""
        width = get_with_def(self.data, 'width', "100%")
        height = get_with_def(self.data, 'height', "100%")
        is_vertical = parent_direction is 'column' or parent_direction is 'column-reverse'
        # is_same_direction = current_direction == parent_direction
        if width.isdigit():
            if not is_vertical:
                style_str += " flex-grow: %s;" % width
        elif width.find("px") >= 0:
            print("build_default_style >>> ", width.find("px"), width, 'x', height)
            style_str = append(style_str, 'width', width)
        else:
            print("build_default_style >>>else ", is_vertical, width.find("px"), width, 'x', height)
            if is_vertical:
                style_str += " align-self: stretch;"
            else:
                style_str = append(style_str, 'width', width)

        if height.isdigit():
            if is_vertical:
                style_str += " flex-grow: %s;" % height
        elif height.find("px") >= 0:
            style_str = append(style_str, 'height', height)
        else:
            if not is_vertical:
                style_str += " align-self: stretch;"
            else:
                style_str = append(style_str, 'height', height)
        style_str += self.append('margin', "margin")
        style_str += self.append('padding', "padding")
        style_str += self.append("background", 'background-color')
        return style_str
