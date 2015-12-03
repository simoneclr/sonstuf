ALTER TABLE sonstuf.offererrank DROP FOREIGN KEY fk_offererrank_offer1;
ALTER TABLE sonstuf.offererrank DROP PRIMARY KEY;
ALTER TABLE sonstuf.offererrank CHANGE offer_idoffer idoffer int NOT NULL;
ALTER TABLE sonstuf.offererrank
ADD CONSTRAINT fk_offererrank_offer1
FOREIGN KEY (idoffer) REFERENCES offer (idoffer);
ALTER TABLE sonstuf.offererrank ADD PRIMARY KEY (idoffer);