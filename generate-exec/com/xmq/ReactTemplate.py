
from jinja2 import loaders, FileSystemLoader, Environment

class Person(object):
    def __init__(self ,name ,age):
        self.name = name
        self.age = age

    def get_info(self):
        return self.name + ',' + str(self.age)
# PATH_BASE = "../../"
PATH_BASE = "D:/workspace/generate/GenerateDemo/generate-exec/"
PATH_TEMPLATE = PATH_BASE+"template/react/"
PATH_OUTPUT = PATH_BASE+"outputs/"
PATH_LAYOUT = PATH_TEMPLATE

# def conatiner():
#     pass
#
# def type(var,x):
#     return {
#             'container': container(x),
#             'b': lambda x: x+2,
#             'c': lambda x: x+3,
#     }[var](x)

# TemplateEnv = Environment(loader=FileSystemLoader(searchpath="./", encoding='utf-8'))


def get_with_def(data, key, default=""):
    result = default
    if data is not None:
        result= data.get(key, default)
    return result

def append(base_data, key, value):
    if value is not None and value is not "":
        base_data += " %s: %s;" %( key, value)
    return base_data

class BaseWidget(object):
    def __init__(self, data):
        self.data= data

    def append(self, key, inputkey, default=""):
        if self.data is not None:
            return append("", inputkey,  self.data.get(key, default))
        return ""
    def render(self, temp_name, data_map={}):
        TemplateEnv = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
        # TemplateEnv.filters['get_attrs', self.get_attrs]
        template = TemplateEnv.get_template(temp_name)
        data = data_map
        return template.render(data)

    def content_generate(self, parent_direction):
        return ""

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        # display = get_with_def(self.data, 'display', "flex")
        # width = get_with_def(self.data, 'width', "100%")
        # height = get_with_def(self.data, 'height', "100%")
        # return self.data
        return {'style':style_str}

    def generate(self, parent_direction, curr_direction = None):
        if curr_direction is None:
            content = self.content_generate(parent_direction)
        else:
            content = self.content_generate(curr_direction)
        return self.render(self.render_name(), {"Tag": self.render_tag_name(), 'attrs': self.get_attrs(parent_direction, curr_direction).items(), "content": content})
    def render_name(self):
        return "widget.html"
    def render_tag_name(self):
        return "div"

    def build_default_style(self, parent_direction, current_direction=None):
        # style_str = "display: flex;"
        style_str = ""
        height = get_with_def(self.data, 'height', "100%")
        width = get_with_def(self.data, 'width', "100%")
        is_vertical = parent_direction is 'column' or parent_direction is 'column-reverse'
        # is_same_direction = current_direction == parent_direction
        if width.isdigit():
            if not is_vertical:
                style_str+=" flex-grow: %s;"%width
                # if current_direction is None or not is_same_direction:
                #     style_str = append(style_str, 'width', "100%")
                # style_str= append(style_str, 'min-width', "100px")
            else:
                style_str= append(style_str, 'width', "100%")
        # elif width is '-1':
        #     if is_vertical:
        #         width =1
        #     else:
        #         width =0
        #     style_str += " flex-grow: %s;" % width
            # style_str= append(style_str, 'width', "100%")
        else:
            style_str= append(style_str, 'width', width)

        if height.isdigit() :
            if is_vertical:
                style_str+=" flex-grow: %s;"%height
                # if current_direction is None or not is_same_direction:
                #     style_str = append(style_str, 'height', "100%")
            #     style_str= append(style_str, 'min-height', "50px")
            else:
                style_str= append(style_str, 'height', "100%")
        # elif height is '-1':
        #     if not is_vertical:
        #         height =1
        #     else:
        #         height =0
        #     style_str += " flex-grow: %s;" % height
        else:
            style_str= append(style_str, 'height', height)
        style_str += self.append( 'margin', "margin")
        style_str += self.append( 'padding', "padding")
        style_str += self.append( "background",  'background-color')
        return style_str;

class TextWidget(BaseWidget):
    def __init__(self, data):
        BaseWidget.__init__(self, data)

    def get_attrs(self, parent_direction, curr_direction):
        text = get_with_def(self.data,  "text","")
        width = get_with_def(self.data,  "width","")
        print("TextWidget get_attrs",text, width, parent_direction, curr_direction)
        style_str = self.build_default_style(parent_direction, 'row')
        class_str = ""
        style_str += self.append( 'textSize', "font-size")
        style_str += self.append( 'textColor', "color")
        # style_str += self.append( 'textStyle', "font-weight")
        return {'style':style_str, 'class': class_str}

    def content_generate(self, parent_direction):
        text = get_with_def(self.data,  "text","")
        return text;

    def render_tag_name(self):
        return "label"
class InputWidget(TextWidget):
    def __init__(self, data):
        super.__init__(self, data)
        # TextWidget.__init__(self, data)

    def render_tag_name(self):
        return "input"
    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = ""
        hint = get_with_def(self.data,  "hint","")
        style_str += self.append( 'text', "defaultvalue")
        style_str += self.append( 'textSize', "font-size")
        style_str += self.append( 'textColor', "color")
        # style_str += self.append( 'textStyle', "font-weight")
        return {"Tag":"input", 'style':style_str, 'class': class_str, 'placeholder': hint}


class Container(BaseWidget):
    def __init__(self, data):
        BaseWidget.__init__(self, data)

    def get_attrs(self, parent_direction, curr_direction):
        style_str = self.build_default_style(parent_direction, curr_direction)
        class_str = "box"
        style_str += self.append( 'display', "display")
        style_str += self.append( 'flex_direction', "flex-direction")
        style_str += self.append( "justify_content",  'justify-content')
        style_str += self.append( "align_items",  'align-items')
        return {"style": style_str, "class": class_str}
    # def render_name(self):
    #
    def generate(self, parent_direction = None):
        flex_direction = get_with_def(self.data, 'flex_direction', "")
        return BaseWidget.generate(self, parent_direction, flex_direction);
        # print("container::: "+flex_direction," ,parent: ", parent_direction, self.get_attrs(parent_direction))
        # return self.render(self.render_name(), {"Tag": self.render_tag_name(), 'attrs': self.get_attrs(parent_direction).items(), "content": self.content_generate(flex_direction)})

    def content_generate(self, parent_direction):
        child_content=""
        children = get_with_def(self.data, 'children', [])
        if children is None or len(children) == 0:
            return child_content
        for child in children:
            if child is None or child['type'] is None:
                continue
            if child['type'] is 'container':
                child_content+= Container(child).generate(parent_direction)
            elif child['type'] is 'input':
                child_content+= InputWidget(child).generate(parent_direction)
            elif child['type'] is 'text':
                child_content+= TextWidget(child).generate(parent_direction)
            else:
                child_content+= BaseWidget(child).generate(parent_direction)
            # print("\n\n=============\nchild", child)
            # print("child_content", child_content)
        return child_content


    def render_name(self):
        return "container.html"

class ReactTemplate:

    def _process(self, data):
        return Container(data).generate()


    def generate(self, data):
        content = self._process(data);
        print("\n\n\ngenerate content", content)
        TemplateEnv = Environment(loader=FileSystemLoader(searchpath=PATH_LAYOUT, encoding='utf-8'))
    #
        tpl = TemplateEnv.get_template('Demo.html')
        with open(PATH_OUTPUT+'page.html' ,'w+', encoding='utf-8') as fout:
            render_content = tpl.render(content = content)
            fout.write(render_content)
    #
    # def template(data):
    #     # 指定模板文件搜索的开始位置
    #     TemplateLoader = FileSystemLoader(searchpath="./", encoding='utf-8')
    #     TemplateEnv = Environment(loader=TemplateLoader)
    #     # 这里的文件位置是以searchpath作为基准的,而不是当前文件夹.
    #     template = TemplateEnv.get_template(PATH_LAYOUT+"demo.xml")
    #     result = template.render({"data": data})
    #     print("template:::")
    #     print(result);

