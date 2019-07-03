class WidgetConfig:
    styles = {}
    parent_direction = 'column'
    current_direction = 'column'
    # def __init__(self):
    #     current_widght_styles ={}

    def add_style(self, style):
        if style is None:
            return
        self.style.update(style)

    def add_style(self, style_name, style_value):
        if style_name is None or style_value is None or style_name is "":
            return
        self.styles.update({style_name, style_value})

    def add_style_with_link(self, style_name, style_value):
        if style_name is None or style_value is None or style_name is "":
            return
        self.styles.update({style_name, '"' + style_value + '"'})

    def get_styles(self):
        return self.styles

    def get_style_if_exsit(self, style):
        style_sr = str(style)
        for style in self.styles:
            style_exist = str(self.styles.get(style))
            if style_exist == style_sr:
                print("get_style_if_exsit: " + str(style))
                return style
        return None

    def is_parent_vertical(self):
        return self.parent_direction is 'column' or self.parent_direction is 'column-reverse'

    # TODO 获取子元素对应配置器
    def get_child_widget_config(self, widget_dict):
        child_config = WidgetConfig()
        child_config.parent_direction = self.current_direction
        child_config.current_direction = widget_dict.get('flex_direction', 'row')
        child_config.parent_config = self
        return child_config
