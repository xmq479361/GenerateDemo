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

class PageWidget(BaseWidget):
    def __init__(self, data, config={}):
        BaseWidget.__init__(self, data, config)

    def get_content_generate(self, parent_direction):
        child_content = ""
        return child_content

    def get_import_arrays(self):
        self.config.add_import('react-native', 'Dimensions')
        self.config.add_import('react-native', 'Platform')
        self.config.add_import('react-native', 'StyleSheet')
        self.config.add_import('react-native', 'PixelRatio')
        import_array =[]
        imports = self.config.get_imports()
        for import_key in imports:
            import_group = imports.get(import_key, None)
            if import_group is not None and len(import_group)>0:
                import_item ="import {"
                lens = len(import_group)
                for index,impt in enumerate(import_group):
                    import_item += "\n\t"+impt
                    if index+1 < lens:
                        import_item +=","
                import_array.append("%s \n} from '%s'"%(import_item, import_key))
        print("import_array", str(import_array))
        return import_array

    def generate_file(self, parent_direction=None):

        # TODO appBar
        app_bar_content = ""
        app_bar = self.get_with_def('appBar', {})
        if app_bar is not None:
            app_bar_content = ContainerWidget(app_bar, self.config).generate(parent_direction)

        # TODO body
        body_content = ""
        body = self.get_with_def('body', {})
        if body is not None:
            body_content += ContainerWidget(body, self.config).generate(parent_direction)

        # TODO styles
        styles=json.dumps(self.config.get_global_style(), indent=4)
        styles = JsonFormatter(styles).render()

        print("\nPage generate() app_bar", app_bar_content)
        template_env = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        tpl = template_env.get_template('Page.html')


        with open(PATH_OUTPUT + 'PageReact.js', 'w+', encoding='utf-8') as fout:
            fout.write(tpl.render(content=body_content, app_bar=app_bar_content, styles= styles, imports= self.get_import_arrays()))
