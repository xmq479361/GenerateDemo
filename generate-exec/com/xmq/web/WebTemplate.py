from jinja2 import Environment, FileSystemLoader

from com.xmq import PATH_OUTPUT
from com.xmq.web import PATH_LAYOUT
from com.xmq.web.Container import ContainerWidget
from com.xmq.web.Page import PageWidget


class WebTemplate:
    def generate(self, data, config=None):
        if config is None:
            config = {}
        if data is None or data['type'] is None:
            return
        if data['type'] is 'page':
            render_content = PageWidget(data, config).generate_file(None)
        elif data['type'] is 'container':
            content = ContainerWidget(data, config).generate('column')
            print("\ngenerate(%s) content" % (data['type']), content)
            template_env = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
            tpl = template_env.get_template('Page.html')
            render_content = tpl.render(content=content)
            with open(PATH_OUTPUT + 'Page.html', 'w+', encoding='utf-8') as fout:
                fout.write(render_content)
        else:
            return
