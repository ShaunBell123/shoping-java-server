
class Scraper:

    def __init__(self, site_name):
        self.site_name = site_name

    def run(self, item):
        return f"Scraping {item} from a generic shop."
    
    def user_agent(self):
        return "Generic User Agent"