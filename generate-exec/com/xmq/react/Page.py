import json

from jinja2 import Environment
from jinja2 import FileSystemLoader

from com.xmq import PATH_OUTPUT
from com.xmq.react import PATH_LAYOUT
from com.xmq.react.Base import BaseWidget
from com.xmq.react.Container import ContainerWidget
from com.xmq.react.Json import JsonFormatter


class AppBarWidget(ContainerWidget):
    def __init__(self, data, config={}):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        style_str  =self.append(style_str, 'display', "display")
        style_str  =self.append(style_str, 'flex_direction', "flex-direction")
        style_str = self.append(style_str,"justify_content", 'justify-content')
        style_str = self.append(style_str,"align_items", 'align-items')
        return {"style": style_str, "class": class_str}


class PageWidget(BaseWidget):
    def __init__(self, data, config={}):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        return {"style": json.load(style_str), "className": class_str}

    def get_content_generate(self, parent_direction):
        child_content = ""
        return child_content

    def generate_file(self, parent_direction=None):
        app_bar_content = ""
        body_content = ""
        app_bar = self.get_with_def('appBar', {})
        if app_bar is not None:
            app_bar_content = ContainerWidget(app_bar, self.config).generate(parent_direction)
        body = self.get_with_def('body', {})
        if body is not None:
            body_content += ContainerWidget(body, self.config).generate(parent_direction)

        print("\nPage generate() app_bar", app_bar_content)
        template_env = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        tpl = template_env.get_template('Page.html')
        # render_content = tpl.render(content=content)
        # stylelist = []
        # for style in self.config.getStyles():
        #     stylelist.append(json.load(style))
        styles=json.dumps(self.config.getStyles(), indent=4)

        styles = JsonFormatter(styles).render()
        render_content = tpl.render(content=body_content, app_bar=app_bar_content, styles= styles)
        with open(PATH_OUTPUT + 'PageReact.js', 'w+', encoding='utf-8') as fout:
            fout.write(render_content)
        print("config: ", self.config)
        print(self.config.getStyles())
        # print(json.load(self.config.getStyles()))
