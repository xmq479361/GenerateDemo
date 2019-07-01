from jinja2 import FileSystemLoader, Environment

from com.xmq.react import PATH_LAYOUT


def get_with_def(data, key, default=""):
    result = default
    if data is not None:
        result = data.get(key, default)
    return result


def append(base_data, key, value):
    if value is not None and value is not "":
        base_data += " %s: %s;" % (key, value)
    return base_data


class BaseWidget(object):
    def __init__(self, data):
        self.data = data

    def append(self, key, inputkey, default=""):
        if self.data is not None:
            return append("", inputkey, self.data.get(key, default))
        return ""

    def render(self, temp_name, data_map={}):
        TemplateEnv = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        # TemplateEnv.filters['get_attrs', self.get_attrs]
        template = TemplateEnv.get_template(temp_name)
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

    def generate(self, parent_direction, curr_direction=None):
        if curr_direction is None:
            content = self.get_content_generate(parent_direction)
        else:
            content = self.get_content_generate(curr_direction)
        return self.render(self.render_name(), {"Tag": self.render_tag_name(),
                                                'attrs': self.get_attrs(parent_direction, curr_direction).items(),
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
        return style_str;
