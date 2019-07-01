from jinja2 import Environment, FileSystemLoader

from com.xmq.react import PATH_LAYOUT, PATH_OUTPUT
from com.xmq.react.Container import ContainerWidget


class ReactTemplate:

    def generate(self, data):
        content = ContainerWidget(data).generate(None)
        print("\n\n\ngenerate content", content)
        TemplateEnv = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        tpl = TemplateEnv.get_template('Demo.html')
        with open(PATH_OUTPUT + 'page.html', 'w+', encoding='utf-8') as fout:
            render_content = tpl.render(content=content)
            fout.write(render_content)
