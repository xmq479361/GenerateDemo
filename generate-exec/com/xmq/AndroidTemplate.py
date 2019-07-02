#
# from jinja2 import Environment ,FileSystemLoader
#
# class Person(object):
#     def __init__(self ,name ,age):
#         self.name = name
#         self.age = age
#
#     def get_info(self):
#         return self.name + ',' + str(self.age)
# PATH_BASE = "../../"
# PATH_TEMPLATE = PATH_BASE+"template/android/"
# PATH_OUTPUT = PATH_BASE+"outputs/"
# PATH_LAYOUT = PATH_TEMPLATE+"layout/"
# class AndroidTemplate:
#
#     def generate(data):
#         env = Environment(loader = FileSystemLoader('./'))
#         tpl = env.get_template(PATH_TEMPLATE+'Demo.html')
#
#         with open(PATH_OUTPUT+'page.txt' ,'w+') as fout:
#             render_content = tpl.render(data = data)
#             fout.write(render_content)
#
#     def template(data):
#         from jinja2 import loaders, FileSystemLoader, Environment
#         # 指定模板文件搜索的开始位置
#         TemplateLoader = FileSystemLoader(searchpath="./", encoding='utf-8')
#         TemplateEnv = Environment(loader=TemplateLoader)
#         # 这里的文件位置是以searchpath作为基准的,而不是当前文件夹.
#         template = TemplateEnv.get_template(PATH_LAYOUT+"demo.xml")
#         result = template.render({"data": data})
#         print("template:::")
#         print(result);
