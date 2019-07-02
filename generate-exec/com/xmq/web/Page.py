from jinja2 import Environment
from jinja2 import FileSystemLoader

from com.xmq import PATH_OUTPUT
from com.xmq.web import PATH_LAYOUT
from com.xmq.web.Base import BaseWidget
from com.xmq.web.Container import ContainerWidget


class AppBarWidget(ContainerWidget):
    def __init__(self, data, config={}):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        style_str += self.append('display', "display")
        style_str += self.append('flex_direction', "flex-direction")
        style_str += self.append("justify_content", 'justify-content')
        style_str += self.append("align_items", 'align-items')
        return {"style": style_str, "class": class_str}


class PageWidget(BaseWidget):
    def __init__(self, data, config={}):
        BaseWidget.__init__(self, data, config)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        return {"style": style_str, "class": class_str}

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
        render_content = tpl.render(content=body_content, app_bar=app_bar_content)
        with open(PATH_OUTPUT + 'Page.html', 'w+', encoding='utf-8') as fout:
            fout.write(render_content)
