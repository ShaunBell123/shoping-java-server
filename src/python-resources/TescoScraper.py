from Scraper import Scraper

class TescoScraper(Scraper):

    def __init__(self):
        super().__init__(site_name="Tesco")
    
    def scrape(self):

        user_agemt = self.user_agent()

        return f"{user_agemt} from {self.site_name}."

