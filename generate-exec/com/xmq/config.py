global global_styles, imports
global_styles = {}
imports = {}


def check_to_append(dict, dict_key, dict_value):
    if dict_key is None or dict_value is None or dict_key is "":
        return
    dict.update({dict_key: dict_value})


class WidgetConfig(object):
    styles = {}
    attributes = {}
    parent_direction = 'column'
    current_direction = 'column'

    def add_import(self, import_from, import_value):
        if import_from is None or import_value is None or import_from is "":
            return
        import_from_arrays = imports.get(import_from, [])
        if import_value not in import_from_arrays:
            # if import_from_arrays.index(import_value)>=0:
            import_from_arrays.append(import_value)
            imports.update({import_from: import_from_arrays})
            # import_from_arrays = imports.get(import_from,())
            # if import_from_arrays.index(import_value)>=0:
            #     import_from_arrays.append(import_value)
            #     imports.update({import_from: import_from_arrays})

    def get_imports(self):
        return imports

    def get_styles(self):
        return self.styles

    def add_style(self, style_name, style_value):
        check_to_append(self.styles, style_name, style_value)

    def add_style_with_link(self, style_name, style_value):
        if style_value is None:
            return
        check_to_append(self.styles, style_name, '"' + style_value + '"')

    def get_styles(self):
        return self.styles

    def get_attributes(self):
        return self.attributes

    def add_attribute(self, attr_name, attr_value):
        check_to_append(self.attributes, attr_name, attr_value)

    def add_attribute_with_link(self, attr_name, attr_value):
        if attr_value is None:
            return
        check_to_append(self.attributes, attr_name, '"%s"' % attr_value)

    def add_global_style(self, style_name, style_value):
        check_to_append(global_styles, style_name, style_value)

    def get_global_style_if_exsit(self, style):
        style_sr = str(style)
        for style in global_styles:
            style_exist = str(global_styles.get(style))
            if style_exist is not None and style_exist == style_sr:
                # print("get_global_style_if_exsit: " + str(style), style_sr)
                return style
        # print("get_global_style_if_exsit None: " , style_sr, global_styles)
        return None

    def get_global_style(self):
        return global_styles

    def is_parent_vertical(self):
        return self.parent_direction is 'column' or self.parent_direction is 'column-reverse'

    # TODO 获取子元素对应配置器
    def get_child_widget_config(self, widget_dict):
        child_config = WidgetConfig()
        child_config.parent_direction = self.current_direction
        child_config.current_direction = widget_dict.get('flex_direction', 'row')
        child_config.styles = {}
        child_config.attributes = {}
        child_config.parent_config = self
        return child_config
